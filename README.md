# How to use Yeti & Yak hardware and build a Yocto image

## Step 1: Clone this repository
Create a folder (e.g. yeti-yak) where everything will be placed.

```
mkdir yeti-yak
cd yeti-yak
git clone https://github.com/PionixPublic/yeti-yak-sdk.git -b kirkstone
cd yeti-yak-sdk
```

## Step 2: Run the setup tool
We are using a tool part of this repository (you find it in the root folder) to sync and initialize the meta layers and prepare everything for the build.
The tool supports 2 operations `init` and `sync`.

```
$ ./setup --help
usage: setup [-h] [--init] [--sync] [--sync_method {fetch,pull}]

Creates the layer structure and synchronizes it

optional arguments:
  -h, --help            show this help message and exit
  --init                Initializes the entire Yocto structure
  --sync                Synchronizes the layers to the given revision or to the given branch HEAD
  --sync_method {fetch,pull}
                        Synchronization method
```

The very first time you want to initialize the layers so all you have to do is to run the tool with the argument `--init`:
```
$ ./setup --init
```

The tool will run and sync the repositories. 
Eventually, if you make any changes to the layers or somebody made changes and you want to sync those changes locally you run it with the option `--sync`. This allows you to sync locally the changes made in the upstream. If you made changes as well to the layers you want to sync, you might want to specify how to sync (`fetch` or `pull`) so that you can have the possibility to rebase or merge the changes. By default the method is `fetch` if no argument is provided.

## Step 3: Build the image
The yeti-yak-sdk repo comes with a build directory (containing only the config folder).
In the config folder there is a default configuration file `local.conf` and the layers configuration `bblayers.conf`.

### Build the image
To start building the image you need to source the yocto environment:

```
$ source ../yeti-yak-sdk-source/poky/oe-init-build-env
### Shell environment set up for builds. ###

You can now run 'bitbake <target>'

Common targets are:
    core-image-minimal
    core-image-full-cmdline
    core-image-sato
    core-image-weston
    meta-toolchain
    meta-ide-support

You can also run generated qemu images with a command like 'runqemu qemux86'

Other commonly useful commands are:
 - 'devtool' and 'recipetool' handle common recipe tasks
 - 'bitbake-layers' handles common layer tasks
 - 'oe-pkgdata-util' handles common target package tasks
```
You are ready to build an image.
If you just want the image run:

```
$ bitbake yeti-yak-image
```


Depending on your computer you might need to go for a coffee a walk or both.
Let it run.

The image file will be located in the subfolder of the `build` folder: `tmp/deploy/images/raspberrypi4/` and is called `yeti-yak-image-raspberrypi4.wic.bz2`.

## Step 4: Flash the image on your target
If you have a board with a SD card you can just flash the image to it.
If not [please follow the flashing instructions.](https://everest.github.io/nightly/hardware/pionix_belay_box.html#flashing-the-yak-board)

