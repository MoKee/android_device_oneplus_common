/*
 * Copyright (c) 2018 The MoKee Open Source Project
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

package org.mokee.pocketmode;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.util.Log;

class PocketSensorImpl extends PocketSensor {

    private static final String TAG = "PocketSensor";
    private static final boolean DEBUG = false;

    static boolean isSupported(Context context) {
        final SensorManager sm = (SensorManager) context.getSystemService(
                Context.SENSOR_SERVICE);
        return Utils.findSensor(sm, "com.oneplus.sensor.pocket") != null;
    }

    PocketSensorImpl(PocketModeService service) {
        super(service);
        mSensor = Utils.findSensor(mSensorManager, "com.oneplus.sensor.pocket");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        boolean isInPocket = event.values[0] != 0;
        if (DEBUG) Log.d(TAG, "isInPocket: " + isInPocket);
        mService.onInPocket(isInPocket);
    }

}
