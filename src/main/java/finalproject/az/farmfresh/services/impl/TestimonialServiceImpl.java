package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.testimonialdtos.*;
import finalproject.az.farmfresh.models.Testimonial;
import finalproject.az.farmfresh.repositories.TestimonialRepository;
import finalproject.az.farmfresh.services.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TestimonialDto> getTestimonials() {
        List<Testimonial> findTestimonials = testimonialRepository.findAll();
        List<TestimonialDto> testimonials=findTestimonials.stream().map(testimonial -> modelMapper.map(testimonial, TestimonialDto.class)).collect(Collectors.toList());
        return testimonials;
    }

    @Override
    public void addTestimonial(TestimonialCreateDto testimonialDto) {
        try{
            Testimonial testimonial = new Testimonial();
            testimonial.setName(testimonialDto.getName());
            testimonial.setPhotoUrl(testimonialDto.getPhotoUrl());

            testimonial.setIsDeleted(false);
            testimonial.setThought(testimonialDto.getThought());

            testimonialRepository.save(testimonial);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<TestimonialHomeDto> getHomeTestimonials() {
        List<TestimonialHomeDto> testimonialDtoList = testimonialRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(testimonial -> modelMapper.map(testimonial, TestimonialHomeDto.class))
                .collect(Collectors.toList());
        return testimonialDtoList;
    }

    @Override
    public void updateTestimonial(TestimonialUpdateDto testimonialDto) {
        Testimonial findTestimonial = testimonialRepository.findById(testimonialDto.getId()).orElseThrow();
        findTestimonial.setId(testimonialDto.getId());
        findTestimonial.setName(testimonialDto.getName());
        findTestimonial.setThought(testimonialDto.getThought());
        findTestimonial.setPhotoUrl(testimonialDto.getPhotoUrl());
        testimonialRepository.saveAndFlush(findTestimonial);
    }

    @Override
    public TestimonialUpdateDto findUpdateTestimonial(Long id) {
        Testimonial testimonial = testimonialRepository.findById(id).orElseThrow();
        TestimonialUpdateDto testimonialUpdateDto = modelMapper.map(testimonial, TestimonialUpdateDto.class);
        return testimonialUpdateDto;
    }

    @Override
    public TestimonialDetailDto testimonialDetail(Long id) {
        Testimonial testimonial = testimonialRepository.findById(id).orElseThrow();
        TestimonialDetailDto testimonialUpdateDto = modelMapper.map(testimonial,TestimonialDetailDto.class);
        return testimonialUpdateDto;
    }

    @Override
    public void removeTestimonial(Long testimonialId) {
        Testimonial testimonial = testimonialRepository.findById(testimonialId).orElseThrow();
        testimonial.setIsDeleted(true);
        testimonialRepository.save(testimonial);
    }
}
