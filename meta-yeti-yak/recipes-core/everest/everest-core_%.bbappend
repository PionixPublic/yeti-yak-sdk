SYSTEMD_SERVICE:${PN}:remove = "everest.service"

FILES:${PN} += "${systemd_system_unitdir}/"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        rm ${D}${systemd_system_unitdir}/everest.service
    fi
}
