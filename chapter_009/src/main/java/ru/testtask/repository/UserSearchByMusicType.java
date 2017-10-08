package ru.testtask.repository;

import ru.testtask.model.MusicType;

/**
 * Created by nikolay on 08/10/17.
 */
public class UserSearchByMusicType implements ISpecification {
    /**
     * music.
     */
    private MusicType musicType;
    /**
     * Constructor.
     * @param musicType - type.
     */
    public UserSearchByMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    @Override
    public String toSqlClauses() {
        return String.format(" join music_type_user as mtu on mtu.id_user = u.login where mtu.id_type = '%s';", musicType.getType());
    }
}
