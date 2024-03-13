FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://mcp2515-can0-spi1-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays \
	file://qca7000.cfg \
	file://drm.cfg \
	file://rpi4_fake-kms.cfg \
	file://fb-support.cfg \
	file://0001-Add-EVerest-bootlogo.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

