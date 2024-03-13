LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
INSANE_SKIP:${PN} = "already-stripped useless-rpaths arch file-rdeps"

SRC_URI = "file://config-yeti-yak-rpi-pwm.yaml \
           file://config-yeti-yak-rpi-iso.yaml \
           file://config-yeti-yak-pwm.yaml \
           file://config-yeti-yak-iso.yaml \
           file://everest.service \
           file://everest-rpi.service \
           file://everest-bootlogo.service \
           file://everest_boot_logo.png \
           "
PV = "0.1"

DEPENDS = " \
    everest-core \
    "

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -d ${D}${sysconfdir}/everest
    install -d ${D}${datadir}/everest
    install -m 0644 ${WORKDIR}/everest.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/everest-rpi.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/everest-bootlogo.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/everest_boot_logo.png ${D}${datadir}/everest/everest_boot_logo.png
    install -m 0644 ${WORKDIR}/config-yeti-yak-pwm.yaml ${D}${sysconfdir}/everest/config-yeti-yak-pwm.yaml
    install -m 0644 ${WORKDIR}/config-yeti-yak-iso.yaml ${D}${sysconfdir}/everest/config-yeti-yak-iso.yaml
    install -m 0644 ${WORKDIR}/config-yeti-yak-rpi-pwm.yaml ${D}${sysconfdir}/everest/config-yeti-yak-rpi-pwm.yaml
    install -m 0644 ${WORKDIR}/config-yeti-yak-rpi-iso.yaml ${D}${sysconfdir}/everest/config-yeti-yak-rpi-iso.yaml
}

FILES:${PN} += "${datadir}/everest/* \
                ${sysconfdir}/everest/* \
                ${systemd_system_unitdir}/everest.service \
                ${systemd_system_unitdir}/everest-rpi.service \
                "

PACKAGES = "${PN}"

inherit systemd
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "everest.service everest-rpi.service everest-bootlogo.service"

