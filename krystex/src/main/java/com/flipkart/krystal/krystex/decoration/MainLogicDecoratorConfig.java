package com.flipkart.krystal.krystex.decoration;

import com.flipkart.krystal.krystex.config.ConfigProvider;
import com.flipkart.krystal.logic.LogicTag;
import com.google.common.collect.ImmutableMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @param decoratorType The id of the decorator
 * @param shouldDecorate A predicate which determines whether the logic decorator should decorate a
 *     logic which has the provided tags applied to it.
 * @param instanceIdGenerator A function which returns the instance id of the logic decorator. The instance
 *     id in conjunction with the decoratorType is used to deduplicate logic decorator instances -
 *     only one instance of a logic decorator of a given instance Id can exist in a scope of the
 *     runtime. The instance Id is also used to configure the logic decorator via the {@link
 *     ConfigProvider} interface.
 * @param factory A factory which creates an instance of the logic decorator with the given
 *     instanceId.
 */
public record MainLogicDecoratorConfig(
    String decoratorType,
    Predicate<ImmutableMap<String, LogicTag>> shouldDecorate,
    Function<ImmutableMap<String, LogicTag>, String> instanceIdGenerator,
    Function<String, MainLogicDecorator> factory) {}