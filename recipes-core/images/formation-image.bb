require recipes-core/images/core-image-minimal.bb

DESCRIPTION = "Image personnalisée pour la formation"
LICENSE = "MIT"

SKELSERVICE = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'service-systemd', 'service-sysvinit', d)}"
CORE_IMAGE_EXTRA_INSTALL = "bbexample thisis libanswer newuser ${SKELSERVICE}"

inherit extrausers

PASSWD = "\$5\$AQGpN/R5DYMuil.p\$hdLbygmR3TEqqVnOpLaKujWCXAKbrzmW81ldC3Xg0j/"

EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD}' root; \
    usermod -p '${PASSWD}' user; \
"
