package roomescape.domain.theme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.domain.theme.data.ThemeAddRequestDto;
import roomescape.entities.Theme;
import roomescape.repositories.ThemeRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ThemeService {
  final private ThemeRepository themeRepository;

  public List<Theme> findAllThemes() {
    return themeRepository.findAllThemes();
  }

  public Theme findById(Long id) {
    return themeRepository.findById(id);
  }

  public Theme save(ThemeAddRequestDto themeAddRequestDto){
    Theme theme = new Theme(
      themeAddRequestDto.getName(),
      themeAddRequestDto.getDescription(),
      themeAddRequestDto.getThumbnail()
    );

    return themeRepository.save(theme);
  }

  public void deleteThemeById(Long id){
    themeRepository.deleteById(id);
  }
}
