package com.pg.java8.reduce;

import java.util.ArrayList;
import java.util.List;

/*
 * 

Old way:

Optional opt = getIntOptional();
if(opt.isPresent()) {
    Integer value = opt.get();
    // do something with value
}
New way:

Optional opt = getIntOptional();
opt.ifPresent(value -> {
    // do something with value
})

Optional<User> user = ...
user.ifPresent(theUser -> doSomethingWithUser(theUser));
Or even simpler, using a method reference:

Optional<User> user = ...
user.ifPresent(this::doSomethingWithUser);
This is basically the same thing as

Optional<User> user = ...
user.ifPresent(new Consumer<User>() {
    @Override
    public void accept(User theUser) {
        doSomethingWithUser(theUser);
    }
});


 * 
 */
public class ListReduceToOne {

	public static void main(String[] args) {
		List<List<Integer>> lolst = randomListofList();
		lolst.stream().reduce( (ac, cur) -> {
			return ac.size()<cur.size() ? cur : ac;
		}).ifPresent( mxLst -> {
			mxLst.forEach( ech -> {
				System.err.print(ech+",");
			});
		});

	}

	private static List<List<Integer>> randomListofList() {
		List<List<Integer>> lolst = new ArrayList<>();
		for(int i=0; i<10; i++) {
			List<Integer> ilst = new ArrayList<>();
			int nsz = (int)(Math.random()*10);
			for(int j=0; j< nsz; j++) {
				int k = ((int)(Math.random()*10));
				ilst.add(k);
			}
			if(ilst.size() > 0) {
				lolst.add(ilst);
			}
		}
		lolst.forEach(ech -> {
			ech.forEach(itm -> System.out.print(itm +","));
			System.out.println();
		});
		return lolst;
	}

}
