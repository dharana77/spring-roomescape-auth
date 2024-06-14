package roomescape.apply.member.ui.dto;

import roomescape.apply.member.domain.Member;

public record MemberResponse(String name) {

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getName());
    }
}