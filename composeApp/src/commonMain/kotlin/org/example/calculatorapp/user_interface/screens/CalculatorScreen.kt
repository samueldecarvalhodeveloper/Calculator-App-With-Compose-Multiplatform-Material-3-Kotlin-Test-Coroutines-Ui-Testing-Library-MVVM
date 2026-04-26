package org.example.calculatorapp.user_interface.screens

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
import org.example.calculatorapp.constants.UserInterfaceConstants.VIEWFINDER_VALUE_WIDTH
import org.example.calculatorapp.domains.expression_evaluator.ExpressionTokens
import org.example.calculatorapp.user_interface.components.action_bar.ActionBar
import org.example.calculatorapp.user_interface.components.button.Button
import org.example.calculatorapp.user_interface.components.keyboard.Keyboard
import org.example.calculatorapp.user_interface.components.viewfinder.Viewfinder
import org.example.calculatorapp.user_interface.internals.enums.CalculatorCharacters
import org.example.calculatorapp.user_interface.theme.Theme
import org.example.calculatorapp.user_interface.view_models.CalculatorViewModel
import org.example.calculatorapp.user_interface.view_models.ThemeModeViewModel

@Composable
fun CalculatorScreen(
    calculatorViewModel: CalculatorViewModel,
    themeModeViewModel: ThemeModeViewModel,
    screenHeight: Dp
) {
    val calculationExpression = calculatorViewModel.expression
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
                        character = CalculatorCharacters.CLEAN,
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
                        character = CalculatorCharacters.DIVISION,
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
                        character = CalculatorCharacters.MULTIPLICATION,
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
                        character = CalculatorCharacters.BACKSPACE,
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
                        character = CalculatorCharacters.SEVEN,
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
                        character = CalculatorCharacters.EIGHT,
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
                        character = CalculatorCharacters.NINE,
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
                        character = CalculatorCharacters.SUBTRACTION,
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
                        character = CalculatorCharacters.FOUR,
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
                        character = CalculatorCharacters.FIVE,
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
                        character = CalculatorCharacters.SIX,
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
                        character = CalculatorCharacters.ADDITION,
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
                                character = CalculatorCharacters.ONE,
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
                                character = CalculatorCharacters.TWO,
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
                                character = CalculatorCharacters.THREE,
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
                                character = CalculatorCharacters.ZERO,
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
                                character = CalculatorCharacters.POINT,
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
                        character = CalculatorCharacters.EVALUATION,
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
