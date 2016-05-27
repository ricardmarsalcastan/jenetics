/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetix;

import java.util.Optional;
import java.util.stream.Stream;

import org.jenetics.Chromosome;
import org.jenetics.Gene;

import org.jenetix.util.TreeNode;

/**
 * Representation of a tree-node.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public interface TreeGene<A, G extends TreeGene<A, G>> extends Gene<A, G> {

	/**
	 * Return the (optional) parent gene of this tree-gene.
	 *
	 * @param chromosome the chromosome from where to fetch the gene
	 * @return the parent gene, if available
	 * @throws NullPointerException if the given {@code chromosome} is
	 *        {@code null}
	 */
	public Optional<G> getParent(final Chromosome<G> chromosome);

	/**
	 * Return the children stream of the {@code this} tree-gene.
	 *
	 * @param chromosome the chromosome from where to fetch the gene
	 * @return the node children
	 * @throws NullPointerException if the given {@code chromosome} is
	 *        {@code null}
	 */
	public Stream<G> children(final Chromosome<G> chromosome);

	/**
	 * Test whether {@code this} gene is a leaf.
	 *
	 * @return {@code true} if {@code this} gene is a leaf, {@code false}
	 *         otherwise
	 */
	public boolean isLeaf();

	/**
	 * Return a {@link TreeNode} with {@code this} tree-gene as root.
	 *
	 * @param chromosome the chromosome which {@code this} tree-gene is part of
	 * @return a {@link TreeNode} with {@code this} tree-gene as root
	 * @throws NullPointerException if the given {@code chromosome} is
	 *        {@code null}
	 */
	@SuppressWarnings("unchecked")
	public default TreeNode<A> toTreeNode(final Chromosome<G> chromosome) {
		return TreeGenes.toTreeNode((G)this, chromosome);
	}



}
