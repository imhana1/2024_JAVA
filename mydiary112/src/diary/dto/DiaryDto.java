package diary.dto;

public class DiaryDto {
    private String weather;//날씨 저장 문자열
    private String content;//일기 저장 문자열

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        String str = """
                날씨 : %s
                <내용>
                %s
                """.formatted(weather, content);
        return str;
    }
}//class end
