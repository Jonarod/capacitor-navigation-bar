# Install

```
npm i --save @jonarod/capacitor-navigation-bar
npx cap sync
```

then in `android/app/src/main/java/MainActivity.java`, add:

```
import com.jonarod.capacitor.plugins.NavigationBar;
```

then,

```
  add(NavigationBar.class);
```

# Usage

```
import { Plugins } from '@capacitor/core';
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

