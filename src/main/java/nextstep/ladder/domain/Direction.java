package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

import java.util.Objects;

public class Direction {
    private static final String CHECK_CONTIONUOUS = "가로 라인이 겹치는 지 확인해주세요.";
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int STAY = 0;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateContinuous(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateContinuous(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(CHECK_CONTIONUOUS);
        }
    }

    public static Direction first(DirectionStrategy directionStrategy) {
        return directionStrategy.createFirstDirection();
    }

    public Direction unConnectedNext() {
        return new Direction(true, false);
    }

    public Direction next(DirectionStrategy directionStrategy) {
        return directionStrategy.createNextDirection(this);
    }

    public Direction last() {
        return new Direction(right, false);
    }

    public boolean hasLeftDirection() {
        return left;
    }

    public boolean hasRightDirection() {
        return right;
    }

    public int move() {
        if (left) {
            return MOVE_LEFT;
        }

        if (right) {
            return MOVE_RIGHT;
        }

        return STAY;
    }

    public boolean rightSide() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
