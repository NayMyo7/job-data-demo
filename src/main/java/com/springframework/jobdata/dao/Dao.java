package com.springframework.jobdata.dao;

import java.util.List;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
public interface Dao<T> {
    List<T> getAll();
}
