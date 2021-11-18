package net.yoonaxes.auth.configuration.impl;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;

@Names(
        modifier = NameModifier.TO_LOWER_CASE,
        strategy = NameStrategy.HYPHEN_CASE
)
public class DatabaseConfiguration extends OkaeriConfig {

    @CustomKey("mongo-url")
    @Comment("A database is in TODO list.")
    public String mongoURL = "mongodb://127.0.0.1/";

    @Comment("A prefix for collection names.")
    public String collectionPrefix = "VelocityAuth_";

    @Comment("A name configuration for collections.")
    public CollectionNames collectionNames = new CollectionNames();

    public static class CollectionNames extends OkaeriConfig {

        public String account = "accounts";

    }
}
