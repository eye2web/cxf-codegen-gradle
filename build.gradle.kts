tasks.register("build") {
    dependsOn(gradle.getIncludedBuilds().map { it.task(":build") })
}