FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://enable-utf8.sh "

do_install:append() {
  install -m 0644 -D ${WORKDIR}/enable-utf8.sh ${D}${sysconfdir}/profile.d/enable-utf8.sh
}

