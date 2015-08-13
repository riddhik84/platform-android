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

package com.ushahidi.android.presentation.view.ui.form.validator;

import com.ushahidi.android.presentation.view.ui.form.FormWidget;

import android.support.annotation.NonNull;

import java.util.regex.Pattern;

/**
 * All validators that uses pattern matching have to extend this class.
 *
 * @author Ushahidi Team <team@ushahidi.com>
 */
public class PatternValidator extends Validator {

    private Pattern mPattern;

    public PatternValidator(String errorMessage, @NonNull Pattern pattern) {
        super(errorMessage);
        mPattern = pattern;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(FormWidget formWidget) {
        return mPattern.matcher(formWidget.getValue()).matches();
    }
}
