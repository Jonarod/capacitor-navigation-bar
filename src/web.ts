import { WebPlugin } from '@capacitor/core';
import { NavigationBarPlugin } from './definitions';

export class NavigationBarWeb extends WebPlugin implements NavigationBarPlugin {
  constructor() {
    super({
      name: 'NavigationBar',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

const NavigationBar = new NavigationBarWeb();

export { NavigationBar };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(NavigationBar);
