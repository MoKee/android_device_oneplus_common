#
# Copyright (C) 2016 The CyanogenMod Project
#               2017 The MoKKee Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Doze
# PRODUCT_PACKAGES += \
#     OneplusDoze

# Keyhandler
PRODUCT_PACKAGES += \
    ConfigPanel

# Overlays
DEVICE_PACKAGE_OVERLAYS += \
    $(LOCAL_PATH)/overlay

# Recovery
ifneq ($(strip $(TARGET_USES_OPPO_UPDATER)), true)
PRODUCT_PACKAGES += \
    librecovery_updater_oneplus
endif
