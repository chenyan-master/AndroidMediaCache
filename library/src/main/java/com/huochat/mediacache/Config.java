package com.huochat.mediacache;

import com.huochat.mediacache.file.DiskUsage;
import com.huochat.mediacache.file.FileNameGenerator;
import com.huochat.mediacache.headers.HeaderInjector;
import com.huochat.mediacache.sourcestorage.SourceInfoStorage;

import java.io.File;

/**
 * Configuration for proxy cache.
 *
 */
class Config {

    public final File cacheRoot;
    public final FileNameGenerator fileNameGenerator;
    public final DiskUsage diskUsage;
    public final SourceInfoStorage sourceInfoStorage;
    public final HeaderInjector headerInjector;

    Config(File cacheRoot, FileNameGenerator fileNameGenerator, DiskUsage diskUsage, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.cacheRoot = cacheRoot;
        this.fileNameGenerator = fileNameGenerator;
        this.diskUsage = diskUsage;
        this.sourceInfoStorage = sourceInfoStorage;
        this.headerInjector = headerInjector;
    }

    File generateCacheFile(String url) {
        String name = fileNameGenerator.generate(url);
        return new File(cacheRoot, name);
    }

}
