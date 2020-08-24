package com.neemshade.matri.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.neemshade.matri.web.rest.TestUtil;

public class FieldDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldDTO.class);
        FieldDTO fieldDTO1 = new FieldDTO();
        fieldDTO1.setId(1L);
        FieldDTO fieldDTO2 = new FieldDTO();
        assertThat(fieldDTO1).isNotEqualTo(fieldDTO2);
        fieldDTO2.setId(fieldDTO1.getId());
        assertThat(fieldDTO1).isEqualTo(fieldDTO2);
        fieldDTO2.setId(2L);
        assertThat(fieldDTO1).isNotEqualTo(fieldDTO2);
        fieldDTO1.setId(null);
        assertThat(fieldDTO1).isNotEqualTo(fieldDTO2);
    }
}
