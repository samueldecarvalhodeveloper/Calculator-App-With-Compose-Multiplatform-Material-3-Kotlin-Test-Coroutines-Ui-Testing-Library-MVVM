package org.example.calculatorapp.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import calculatorapp.composeapp.generated.resources.Res
import calculatorapp.composeapp.generated.resources.actionbar_menu_toggle_night_mode_content_description
import calculatorapp.composeapp.generated.resources.moon_waning_crescent
import calculatorapp.composeapp.generated.resources.white_balance_sunny
import org.example.calculatorapp.components.action_bar.ActionBar
import org.example.calculatorapp.components.button.Button
import org.example.calculatorapp.components.keyboard.Keyboard
import org.example.calculatorapp.components.viewfinder.Viewfinder
import org.example.calculatorapp.constants.UserInterfaceConstants.VIEWFINDER_VALUE_WIDTH
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.theme.Theme
import org.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import org.example.calculatorapp.view_models.CalculatorViewModel
import org.example.calculatorapp.view_models.ThemeModeViewModel

@Composable
fun CalculatorScreen(
    calculatorViewModel: CalculatorViewModel,
    themeModeViewModel: ThemeModeViewModel,
    screenHeight: Dp
) {
    val calculationExpression = calculatorViewModel.calculationExpression
    val themeMode = themeModeViewModel.themeMode

    val viewFinderScrollState =
        ScrollState(VIEWFINDER_VALUE_WIDTH(calculationExpression.value.length))

    Column(
        modifier = Modifier.fillMaxSize().background(Theme.colors.appBackgroundColor)
    ) {
        ActionBar(
            actionIconDrawableResource = if (themeMode.value) Res.drawable.moon_waning_crescent
            else Res.drawable.white_balance_sunny,
            actionContentDescriptionStringResource = Res.string.actionbar_menu_toggle_night_mode_content_description,
        ) {
            themeModeViewModel.toggleTheme()
        }
        Viewfinder(
            value = calculationExpression.value,
            screenHeight = screenHeight,
            scrollState = viewFinderScrollState
        )
        Keyboard(screenHeight = screenHeight) {
            Row(
                modifier = Modifier.weight(
                    weight = 1f, fill = true
                ).padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.CLEAN,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.clean()
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.DIVISION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.DIVISION)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.MULTIPLICATION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.MULTIPLICATION)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    )
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.BACKSPACE,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.backspace()
                    }
                }
            }
            Row(
                modifier = Modifier.weight(
                    weight = 1f, fill = true
                ).padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.SEVEN,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.SEVEN)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.EIGHT,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.EIGHT)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.NINE,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.NINE)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    )
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.SUBTRACTION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.SUBTRACTION)
                    }
                }
            }
            Row(
                modifier = Modifier.weight(
                    weight = 1f, fill = true
                ).padding(bottom = 8.dp)
            ) {
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.FOUR,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.FOUR)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.FIVE,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.FIVE)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    ).padding(end = 8.dp)
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.SIX,
                        backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.primaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.SIX)
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    )
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.ADDITION,
                        backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                        characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                        borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.addCharacter(ExpressionTokens.ADDITION)
                    }
                }
            }
            Row(
                modifier = Modifier.weight(weight = 2f, fill = true).padding(bottom = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(end = 8.dp).weight(weight = 3f, fill = true)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().weight(
                            weight = 1f, fill = true
                        ).padding(bottom = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier.weight(
                                weight = 1f, fill = true
                            ).padding(end = 8.dp)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.ONE,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                                screenHeight = screenHeight
                            ) {
                                calculatorViewModel.addCharacter(ExpressionTokens.ONE)
                            }
                        }
                        Box(
                            modifier = Modifier.weight(
                                weight = 1f, fill = true
                            ).padding(end = 8.dp)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.TWO,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                                screenHeight = screenHeight
                            ) {
                                calculatorViewModel.addCharacter(ExpressionTokens.TWO)
                            }
                        }
                        Box(
                            modifier = Modifier.weight(
                                weight = 1f, fill = true
                            )
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.THREE,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                                screenHeight = screenHeight
                            ) {
                                calculatorViewModel.addCharacter(
                                    ExpressionTokens.THREE,

                                    )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxSize().weight(
                            weight = 1f, fill = true
                        )
                    ) {
                        Box(
                            modifier = Modifier.weight(weight = 2f, fill = true).padding(end = 8.dp)
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.ZERO,
                                backgroundColor = Theme.colors.primaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.primaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.primaryBlueButtonBorderColor,
                                screenHeight = screenHeight
                            ) {
                                calculatorViewModel.addCharacter(ExpressionTokens.ZERO)
                            }
                        }
                        Box(
                            modifier = Modifier.weight(
                                weight = 1f, fill = true
                            )
                        ) {
                            Button(
                                character = UserInterfaceCalculatorCharacters.POINT,
                                backgroundColor = Theme.colors.secondaryBlueButtonBackgroundColor,
                                characterColor = Theme.colors.secondaryBlueButtonCharacterColor,
                                borderColor = Theme.colors.secondaryBlueButtonBorderColor,
                                screenHeight = screenHeight
                            ) {
                                calculatorViewModel.addCharacter(
                                    ExpressionTokens.POINT,

                                    )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier.weight(
                        weight = 1f, fill = true
                    )
                ) {
                    Button(
                        character = UserInterfaceCalculatorCharacters.EVALUATION,
                        backgroundColor = Theme.colors.yellowButtonBackgroundColor,
                        characterColor = Theme.colors.yellowButtonCharacterColor,
                        borderColor = Theme.colors.yellowButtonBorderColor,
                        screenHeight = screenHeight
                    ) {
                        calculatorViewModel.evaluate()
                    }
                }
            }
        }
    }
}
