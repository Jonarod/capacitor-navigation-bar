declare module '@capacitor/core' {
  interface PluginRegistry {
    NavigationBar: NavigationBarPlugin;
  }
}

export interface NavigationBarPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
