import { Controller, Get } from '@nestjs/common';
import { GreetingsService } from './greetings.service';

@Controller()
export class GreetingsController {
  private readonly greetingService: GreetingsService;
  constructor(greetingService: GreetingsService) {
    this.greetingService = greetingService;
  }

  @Get('namaste')
  getNamaste() {
    return this.greetingService.getNamaste();
  }
}
