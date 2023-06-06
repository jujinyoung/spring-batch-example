package io.spring.batch.springbatch.executioncontext;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@RequiredArgsConstructor
public class ExecutionContextConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EcTasklet1 ecTasklet1;
    private final EcTasklet2 ecTasklet2;
    private final EcTasklet3 ecTasklet3;
    private final EcTasklet4 ecTasklet4;

//    @Bean
    public Job BatchJob() {
        return this.jobBuilderFactory.get("Job")
                .start(step1())
                .next(step2())
                .next(step3())
                .next(step4())
                .build();
    }

//    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(ecTasklet1)
                .build();
    }

//    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(ecTasklet2)
                .build();
    }

//    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet(ecTasklet3)
                .build();
    }

//    @Bean
    public Step step4() {
        return stepBuilderFactory.get("step4")
                .tasklet(ecTasklet4)
                .build();
    }
}
