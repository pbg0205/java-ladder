package ladder.controller.dto;

import java.util.List;

public class LadderGenerationResponse {

    private final List<String> participantNames;
    private final int ladderWidth;
    private final List<LadderLine> ladderLines;
    private final List<String> gameResults;

    public LadderGenerationResponse(List<String> participantNames, int ladderWidth, List<LadderLine> ladderLines, List<String> gameResults) {
        this.participantNames = participantNames;
        this.ladderWidth = ladderWidth;
        this.ladderLines = ladderLines;
        this.gameResults = gameResults;
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public List<String> getGameResults() {
        return gameResults;
    }
}