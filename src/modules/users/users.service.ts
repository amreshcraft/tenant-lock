// user/user.service.ts
import { Injectable, ConflictException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import * as bcrypt from 'bcrypt';
import { User } from './users.entity';
import { CreateUserDto } from './dto/create-user.dto';

@Injectable()
export class UserService {
  constructor(
    @InjectRepository(User)
    private userRepo: Repository<User>,
  ) {}

  async createUser(dto: CreateUserDto): Promise<User> {
    const existing = await this.userRepo.findOne({
      where: { email: dto.email },
    });
    console.log('existing', existing);
    if (existing) {
      throw new ConflictException('Email already exists');
    }

    const hashedPassword = await bcrypt.hash(dto.password, 10);

    const user = this.userRepo.create({
      name: dto.name,
      email: dto.email,
      password: hashedPassword,
    });
    console.log('user: ', user);
    return this.userRepo.save(user);
  }
}
