/**
 * Copyright 2017 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.priam.backup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by aagrawal on 1/31/17.
 */

	/*
	 * Encapsulates metadata for a backup for a day.
	 */
public class BackupMetadata {
    private List<String> backups = new ArrayList<String>();
    private String key;
    private String token;
    private Date start, completed;

    /*
    Represents a granular (includes hour and secs) backup for the day.
    @param key see formatKey() for format
    @param backupDate format is yyyymmddhhss
     */
    public BackupMetadata(String key, String backupDate) {
        this.key = key;
        backups.add(backupDate);
    }
    /*
    Represents a high level(does not includ hour and secs) backup for the day.
    @param key see formatKey() for format
    @param backupDate format is yyyymmddhhss
     */
    public BackupMetadata(String key) {
        this.key = key;
    }

    /*
     * @return a list of all backups for the day, empty list if no backups.
     */
    public Collection<String> getBackups() {
        return backups;
    }

    public void setKey(String key) {
        this.key = key;
    }
    /*
     * @return the date of the backup.  Format of date is yyyymmdd.
     */
    public String getKey() {
        return this.key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getStartTime() {
        return start;
    }

    public void setStartTime(Date start) {
        this.start = start;
    }

    public void setCompletedTime(Date completed) {
        this.completed = completed;
    }

    public Date getCompletedTime() {
        return this.completed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BackupMetadata{");
        sb.append("backups=").append(backups);
        sb.append(", key='").append(key).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append(", start=").append(start);
        sb.append(", completed=").append(completed);
        sb.append('}');
        return sb.toString();
    }
}