# Install

```
npm i --save @jonarod/capacitor-navigation-bar
npx cap sync
```


# Usage

```
import { NavigationBar } from Plugins;

...

var options = {
  bgColor: "#FFFFFF",
  theme: "light", // or "dark"
  transparent: false,
  hide: false
}

NavigationBar.set(options);
```

# Work In Progress

`transparent` and `hide` options won't work for the moment... this is work in progress. I am open to PRs ;)

