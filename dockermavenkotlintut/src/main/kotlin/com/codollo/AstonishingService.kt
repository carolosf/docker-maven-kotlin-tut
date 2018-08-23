package com.codollo

class AstonishingService {
    // This is bad - dependencies should be wired and configured as close to main as possible
    val dbUser = System.getProperty("DB_USERNAME")
}