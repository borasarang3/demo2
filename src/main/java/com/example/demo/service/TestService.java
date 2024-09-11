package com.example.demo.service;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.Test;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class TestService {

    private final TestRepository testRepository;
    private final ModelMapper modelMapper;

    public void register(TestDTO testDTO){

        Test test = new Test();
        test.setWriter(testDTO.getWriter());
        test.setTitle(testDTO.getTitle());
        test.setContent(testDTO.getContent());

        Test test1 = modelMapper.map(testDTO, Test.class);

        testRepository.save(test);
    }

    public List<TestDTO> list () {

        List<Test> testList = testRepository.findAll();

        List<TestDTO> testDTOList = testList.stream()
                .map(test -> modelMapper.map(test, TestDTO.class)).collect(Collectors.toList());

        return testDTOList;
    }

    public TestDTO read(Long tno) {
        Test test = testRepository.findById(tno)
                .orElseThrow();

        TestDTO testDTO = modelMapper.map(test, TestDTO.class);

        return testDTO;
    }

    public void modify(TestDTO testDTO){
        log.info("testDTO : " + testDTO);
        Test test = modelMapper.map(testDTO, Test.class);
        testRepository.save(test);
    }

    public void remove (Long tno) {
        testRepository.deleteById(tno);
    }

}
