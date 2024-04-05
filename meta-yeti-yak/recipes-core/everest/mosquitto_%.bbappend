FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "file://mosquitto.conf"

do_install:append() {
    install -m 0755 ${WORKDIR}/mosquitto.conf ${D}${sysconfdir}/mosquitto
}
