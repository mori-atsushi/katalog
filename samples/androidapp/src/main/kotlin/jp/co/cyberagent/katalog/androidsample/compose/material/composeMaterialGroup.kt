package jp.co.cyberagent.katalog.androidsample.compose.material

import jp.co.cyberagent.katalog.group

val composeMaterialGroup = group("Compose Material") {
    compose("BottomAppBar") {
        SampleBottomAppBar()
    }
    compose("BottomNavigation") {
        SampleBottomNavigation()
    }
    group("Button") {
        compose("Button") {
            SampleButton()
        }
        compose("Button with Icon") {
            ButtonWithIcon()
        }
    }
    compose("Card") {
        SampleCard()
    }
    compose("Checkbox") {
        SampleCheckbox()
    }
    compose("CircularProgressIndicator") {
        SampleCircularProgressIndicator()
    }
    compose("DropdownMenu") {
        SampleDropdownMenu()
    }
    group("ExtendedFloatingActionButton") {
        compose("ExtendedFloatingActionButton") {
            SampleExtendedFloatingActionButton()
        }
        compose("ExtendedFloatingActionButton full width") {
            SampleExtendedFloatingActionButtonFullWidth()
        }
    }
    compose("FloatingActionButton") {
        SampleFloatingActionButton()
    }
    compose("Icon") {
        SampleIcon()
    }
    compose("IconButton") {
        SampleIconButton()
    }
    compose("IconToggleButton") {
        SampleIconToggleButton()
    }
    compose("LinearProgressIndicator") {
        SampleLinearProgressIndicator()
    }
    compose("OutlinedButton") {
        SampleOutlinedButton()
    }
    group("RadioButton") {
        compose("RadioButton") {
            SampleRadioButton()
        }
        compose("RadioButton with labels") {
            SampleRadioButtonWithLabels()
        }
    }
    compose("Scaffold") {
        SampleScaffold()
    }
    group("Slider") {
        compose("Slider") {
            SampleSlider()
        }
        compose("Slider with steps") {
            SampleSliderWithSteps()
        }
    }
    group("Snackbar") {
        compose("Snackbar") {
            SampleSnackbar()
        }
        compose("Custom with SnackbarHost") {
            SampleSnackbarWithSnackbarHost()
        }
    }
    compose("Surface") {
        SampleSurface()
    }
    compose("Switch") {
        SampleSwitch()
    }
    compose("TabRow") {
        SampleTabRow()
    }
    compose("Text") {
        SampleText()
    }
    compose("TextButton") {
        SampleTextButton()
    }
    group("TextField") {
        compose("TextField") {
            SampleTextField()
        }
        compose("TextField with placeholder") {
            SampleTextFieldWithPlaceholder()
        }
        compose("TextField with icons") {
            SampleTextFieldWithIcons()
        }
        compose("TextField is error") {
            SampleTextFieldIsError()
        }
        compose("TextField with message") {
            SampleTextFieldWithMessage()
        }
        compose("TextField for password") {
            SampleTextFieldForPassword()
        }
    }
    compose("TopAppBar") {
        SampleTopAppBar()
    }
}
