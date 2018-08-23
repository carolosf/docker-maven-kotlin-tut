package com.codollo

import uy.klutter.config.typesafe.FileConfig
import uy.klutter.config.typesafe.loadConfig
import uy.klutter.config.typesafe.value
import java.io.File

fun main(args: Array<String>) {
    // Invisible dependencies - fragile code
    AstonishingService()

    // Better
    val cfg = loadConfig(FileConfig(File("conf/application.conf"), true))
    val service = Service(cfg.value("db.username").asString())
    service.handle()
}

