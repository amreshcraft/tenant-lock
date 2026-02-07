import { Injectable } from '@nestjs/common';

@Injectable()
export class GreetingsService {
  getNamaste(): string {
    return 'Namaste World!';
  }
}
