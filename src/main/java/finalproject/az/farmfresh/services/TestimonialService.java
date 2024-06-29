package finalproject.az.farmfresh.services;


import finalproject.az.farmfresh.dtos.testimonialdtos.*;

import java.util.List;

public interface TestimonialService {
    List<TestimonialDto> getTestimonials();
    void addTestimonial(TestimonialCreateDto testimonialDto);
    List<TestimonialHomeDto> getHomeTestimonials();
    void updateTestimonial(TestimonialUpdateDto testimonialDto);
    TestimonialUpdateDto findUpdateTestimonial(Long id);
    TestimonialDetailDto testimonialDetail(Long id);
    void removeTestimonial(Long testimonialId);
}
