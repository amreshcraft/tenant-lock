// user/user.controller.ts
import { Controller, Post, Body } from '@nestjs/common';
import { UserService } from './users.service';
import { CreateUserDto } from './dto/create-user.dto';

@Controller()
export class UserController {
  constructor(private readonly userService: UserService) {}

  @Post('users')
  create(@Body() dto: CreateUserDto) {
    return this.userService.createUser(dto);
  }
}
