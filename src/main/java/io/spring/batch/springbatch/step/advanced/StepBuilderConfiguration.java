//package io.spring.batch.springbatch.step.advanced;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.*;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.List;
//
//
//@RequiredArgsConstructor
//@Configuration
//public class StepBuilderConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job StepBuilderJob(){
//        return jobBuilderFactory.get("StepBuilderJob")
//                .incrementer(new RunIdIncrementer())
//                .start(StepBuilderStep1())
//                .next(StepBuilderStep2())
//                .next(StepBuilderStep3())
//                .build();
//    }
//
//    @Bean
//    public Step StepBuilderStep1() {
//        return stepBuilderFactory.get("StepBuilderStep1")
//                .tasklet((stepContribution, chunkContext) -> {
//                    System.out.println(" =========================");
//                    System.out.println(" >> step1 Spring Batch!!");
//                    System.out.println(" =========================");
//                    return RepeatStatus.FINISHED;
//                })
//                .build();
//    }
//
//    @Bean
//    public Step StepBuilderStep2() {
//        return stepBuilderFactory.get("StepBuilderStep2")
//                .<String, String>chunk(3)
//                .reader(new ItemReader<String>() {
//                    @Override
//                    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//                        return null;
//                    }
//                })
//                .processor(new ItemProcessor<String, String>() {
//                    @Override
//                    public String process(String s) throws Exception {
//                        return null;
//                    }
//                })
//                .writer(new ItemWriter<String>() {
//                    @Override
//                    public void write(List<? extends String> list) throws Exception {
//
//                    }
//                })
//                .build();
//    }
//
//    @Bean
//    public Step StepBuilderStep3() {
//        return stepBuilderFactory.get("StepBuilderStep3")
//                .partitioner(StepBuilderStep1())
//                .gridSize(2)
//                .build();
//    }
//
//    @Bean
//    public Step StepBuilderStep4() {
//        return stepBuilderFactory.get("StepBuilderStep4")
//                .job(job123())
//                .build();
//    }
//
//    @Bean
//    public Step StepBuilderStep5() {
//        return stepBuilderFactory.get("StepBuilderStep5")
//                .flow(flow())
//                .build();
//    }
//
//    @Bean
//    public Job job123() {
//        return this.jobBuilderFactory.get("job123")
//                .start(StepBuilderStep1())
//                .next(StepBuilderStep2())
//                .next(StepBuilderStep3())
//                .build();
//    }
//
//    @Bean
//    public Flow flow() {
//        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow");
//        flowBuilder.start(StepBuilderStep2()).end();
//        return flowBuilder.build();
//    }
//
//    @Bean
//    public Step chunkStep() {
//        return stepBuilderFactory.get("chunkStep")
//                .<String, String>chunk(10)
//                .reader(new ListItemReader<>(Arrays.asList("item1", "item2", "item3", "item4", "item5")))
//                .processor(new ItemProcessor<String, String>() {
//                    @Override
//                    public String process(String item) throws Exception {
//                        return item.toUpperCase();
//                    }
//                })
//                .writer(new ItemWriter<String>() {
//                    @Override
//                    public void write(List<? extends String> items) throws Exception {
//                        items.forEach(item -> System.out.println(item));
//                    }
//                })
//                .build();
//    }
//}
