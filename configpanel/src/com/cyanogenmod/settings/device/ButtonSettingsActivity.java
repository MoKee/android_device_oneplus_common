/*
 * Copyright (C) 2017 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.settings.device;

import android.content.Context;
import android.os.Bundle;

import com.android.settingslib.drawer.SettingsDrawerActivity;

import org.mokee.internal.util.FileUtils;

public class ButtonSettingsActivity extends SettingsDrawerActivity {

    static boolean isSupported() {
        return FileUtils.fileExists(ButtonConstants.BUTTON_SWAP_NODE) ||
        		ButtonUtils.isSliderSupported();
    }

    static void restoreState(Context context) {
        if (isSupported()) {
            Utils.enableComponent(context, ButtonSettingsActivity.class);
            ButtonSettingsFragment.restoreSliderStates(context);
        } else {
            Utils.disableComponent(context, ButtonSettingsActivity.class);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new ButtonSettingsFragment()).commit();
    }

}
