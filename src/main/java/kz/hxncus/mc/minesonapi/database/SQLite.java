package kz.hxncus.mc.minesonapi.database;

import lombok.NonNull;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;

public class SQLite extends DefaultDatabase {
    public SQLite(@NonNull Plugin plugin, @NonNull String database) {
        this(plugin, database, null);
    }

    public SQLite(@NonNull Plugin plugin, @NonNull String database, @Nullable String tableSQL) {
        this(plugin, database, Collections.emptyMap(), tableSQL);
    }

    public SQLite(@NonNull Plugin plugin, @NonNull String database, @NonNull Map<String, String> properties, @Nullable String tableSQL) {
        this(plugin, plugin.getDataFolder().getName(), database, properties, tableSQL);
    }

    public SQLite(@NonNull Plugin plugin, @NonNull String directory, @NonNull String database, @NonNull Map<String, String> properties, @Nullable String tableSQL) {
        super(plugin, "jdbc:sqlite:plugins/" + directory + "/" + database + ".db", "", "", properties, tableSQL);
    }
    @Override
    public Database.Type getType() {
        return Database.Type.SQLITE;
    }
}
