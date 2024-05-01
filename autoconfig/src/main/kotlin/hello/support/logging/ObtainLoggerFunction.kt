package hello.support.logging

import hello.support.logging.impl.DelegatingLogger

fun getLogger(clazz: Class<*>): Logger = DelegatingLogger(clazz)
