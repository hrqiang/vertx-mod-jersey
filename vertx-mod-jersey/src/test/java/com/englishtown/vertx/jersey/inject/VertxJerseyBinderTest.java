/*
 * The MIT License (MIT)
 * Copyright © 2013 Englishtown <opensource@englishtown.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.englishtown.vertx.jersey.inject;

import org.glassfish.hk2.api.IterableProvider;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link VertxJerseyBinder} unit tests
 */
@SuppressWarnings("unchecked")
public class VertxJerseyBinderTest {

    @Test
    public void testVertxRequestProcessorFactory() {

        IterableProvider<VertxRequestProcessor> providers = mock(IterableProvider.class);
        VertxJerseyBinder.VertxRequestProcessorFactory factory;
        List<VertxRequestProcessor> result;

        List<VertxRequestProcessor> list = Arrays.asList(
                mock(VertxRequestProcessor.class),
                mock(VertxRequestProcessor.class));

        when(providers.iterator()).thenReturn(list.iterator());

        factory = new VertxJerseyBinder.VertxRequestProcessorFactory(providers);
        result = factory.provide();

        assertNotNull(result);
        assertEquals(2, result.size());

        factory.dispose(result);

    }

    @Test
    public void testVertxResponseProcessorFactory() {

        IterableProvider<VertxResponseProcessor> providers = mock(IterableProvider.class);
        VertxJerseyBinder.VertxResponseProcessorFactory factory;
        List<VertxResponseProcessor> result;

        List<VertxResponseProcessor> list = Arrays.asList(
                mock(VertxResponseProcessor.class),
                mock(VertxResponseProcessor.class));

        when(providers.iterator()).thenReturn(list.iterator());

        factory = new VertxJerseyBinder.VertxResponseProcessorFactory(providers);
        result = factory.provide();

        assertNotNull(result);
        assertEquals(2, result.size());

        factory.dispose(result);

    }

    @Test
    public void testVertxPostResponseProcessorFactory() {

        IterableProvider<VertxPostResponseProcessor> providers = mock(IterableProvider.class);
        VertxJerseyBinder.VertxPostResponseProcessorFactory factory;
        List<VertxPostResponseProcessor> result;

        List<VertxPostResponseProcessor> list = Arrays.asList(
                mock(VertxPostResponseProcessor.class),
                mock(VertxPostResponseProcessor.class));

        when(providers.iterator()).thenReturn(list.iterator());

        factory = new VertxJerseyBinder.VertxPostResponseProcessorFactory(providers);
        result = factory.provide();

        assertNotNull(result);
        assertEquals(2, result.size());

        factory.dispose(result);

    }

}
