package com.iposprinter.Utils;

/**
 * Created by Administrator on 2017/7/25.
 */
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.SoftReference;

/**
 * Created by liuchangfa on 2016.
 * Handler creation tool,
 * using soft references to prevent memory leaks
 */

public class HandlerUtils {

    private static final long serialVersionUID = 0L;

    /**
     * Inherit this interface where the handler is used,
     * and then give the instantiated reference to the instantiated handler
     */
    public interface IHandlerIntent {
        void handlerIntent(Message message);
    }

    public static final class MyHandler extends Handler
    {
        private SoftReference<IHandlerIntent> owner;

        public MyHandler(IHandlerIntent t) {
            owner = new SoftReference<>(t);
        }

        public MyHandler(Looper looper, IHandlerIntent t) {
            super(looper);
            owner = new SoftReference<>(t);
        }

        @Override
        public void handleMessage(Message msg) {
            IHandlerIntent t = owner.get();
            if (null != t) {
                t.handlerIntent(msg);
            }
        }
    }
}
