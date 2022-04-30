package ladder.model;

import ladder.exception.InvalidLineException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LineTest {

    @ParameterizedTest
    @MethodSource("lineProvider")
    @DisplayName("연속적으로 연결되지 않았을 경우 정상적인 라인을 생성한다")
    void createLine(List<Point> points) {
        assertThat(Line.create(points)).isInstanceOf(Line.class);
    }

    static Stream<Arguments> lineProvider() {
        return Stream.of(
                arguments(
                        List.of(
                                Point.of(Direction.of(false, true)),
                                Point.of(Direction.of(true, false)),
                                Point.of(Direction.of(false, true)),
                                Point.of(Direction.of(true, false)),
                                Point.of(Direction.of(false, false))
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("invalidLineProvider")
    @DisplayName("올바르지 않은 라인일 경우 예외를 반환한다")
    void throwInvalidLineException(List<Point> points) {
        assertThatThrownBy(() -> Line.create(points)).isInstanceOf(InvalidLineException.class);
    }

    static Stream<Arguments> invalidLineProvider() {
        return Stream.of(
                arguments(
                        List.of(
                                Point.of(Direction.of(false, true)),
                                Point.of(Direction.of(true, true)),
                                Point.of(Direction.of(true, true)),
                                Point.of(Direction.of(true, false)),
                                Point.of(Direction.of(false, false))
                        )
                )
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiter = ':')
    @DisplayName("라인에서 포인트 값에 따라서 인덱스의 좌우 이동을 확인한다")
    void move(int currentIndex, int expectedIndex) {
        Line line = Line.create(List.of(
                Point.of(Direction.of(false, true)),
                Point.of(Direction.of(true, false)),
                Point.of(Direction.of(false, false))));

        assertThat(line.move(currentIndex)).isEqualTo(expectedIndex);
    }

}