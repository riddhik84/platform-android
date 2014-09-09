/*
 * Copyright (c) 2014 Ushahidi.
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program in the file LICENSE-AGPL. If not, see
 * https://www.gnu.org/licenses/agpl-3.0.html
 */
package com.ushahidi.android.core.entity;

import com.ushahidi.android.core.Entity;

/**
 * Deployment entity
 *
 * @author  Ushahidi Team <team@ushahidi.com>
 */
public class Deployment extends Entity {

    private int mId;

    @Override
    protected int getId() {
        return 0;
    }

    @Override
    protected void setId(int id) {
        mId = id;
    }
}
