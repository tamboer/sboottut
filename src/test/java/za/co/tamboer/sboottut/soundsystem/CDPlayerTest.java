package za.co.tamboer.sboottut.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.tamboer.sboottut.config.CDPlayerConfig;
import za.co.tamboer.sboottut.soundsystem.cdplayer.CDPlayer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Autowired
    private CDPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        assertTrue(systemOutRule.getLog().toString().contains("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles"));

//        assertEquals("14:15:01.521 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test method: context [DefaultTestContext@47db50c5 testClass = CDPlayerTest, testInstance = za.co.tamboer.sboottut.soundsystem.CDPlayerTest@1f021e6c, testMethod = play@CDPlayerTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@5c072e3f testClass = CDPlayerTest, locations = '{}', classes = '{class za.co.tamboer.sboottut.config.CDPlayerConfig}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@15d0c81b, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@4d41cee, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@1a8a8f7c], contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]], attributes = map[[empty]]], class annotated with @DirtiesContext [false] with mode [null], method annotated with @DirtiesContext [false] with mode [null].\n" +
//                        "14:15:01.523 [main] DEBUG org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate - Retrieved ApplicationContext from cache with key [[MergedContextConfiguration@5c072e3f testClass = CDPlayerTest, locations = '{}', classes = '{class za.co.tamboer.sboottut.config.CDPlayerConfig}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@15d0c81b, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@4d41cee, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@1a8a8f7c], contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]\n" +
//                        "14:15:01.523 [main] DEBUG org.springframework.test.context.cache - Spring test ApplicationContext cache statistics: [DefaultContextCache@29e495ff size = 1, maxSize = 32, parentContextCount = 0, hitCount = 1, missCount = 1]\n" +
//                        "14:15:01.766 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'org.springframework.boot.test.mock.mockito.MockitoBeans'\n" +
//                        "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",
//                systemOutRule.getLog().toString().contains("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles"));

//        assertEquals(
//                "Playing Sgt. Pepper's Lonely Hearts Club Band" +
//                        " by The Beatles\n",
//                systemOutRule.getLog());
    }
}