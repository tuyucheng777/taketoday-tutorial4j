package cn.tuyucheng.taketoday.patterns.data;

import static cn.tuyucheng.taketoday.patterns.data.Strategies.*;

public sealed interface Strategy permits Ones, Twos, OnePair, TwoPairs, ThreeOfaKind {
}