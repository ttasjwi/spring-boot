package support.logging

import support.logging.impl.DelegatingLogger

fun getLogger(clazz: Class<*>): Logger = DelegatingLogger(clazz)
