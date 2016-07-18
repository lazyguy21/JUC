package lazyguy.yyf.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by tobi on 16-7-18.
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference atomicReference = new AtomicReference();
        User user = new User();
        user.setId(1L);
        User user2 = new User();
        user2.setId(1L);
        Object o = atomicReference.get();
        System.out.println(o);
        atomicReference.set(user);
        System.out.println(atomicReference.get());
//        atomicReference.compareAndSet(user, user2);
        atomicReference.compareAndSet(user2, user2);
        //compareAndSet这个其实比较的是他们的内存地址
        System.out.println(atomicReference.get());
    }
    public static class User{
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return id != null ? id.equals(user.id) : user.id == null;

        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }
}

