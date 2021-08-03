import React from 'react';
import clsx from 'clsx';
import Layout from '@theme/Layout';
import Link from '@docusaurus/Link';
import useDocusaurusContext from '@docusaurus/useDocusaurusContext';
import styles from './index.module.css';

function HomepageHeader() {
  const {siteConfig} = useDocusaurusContext();
  return (
    <header className={clsx('hero hero--primary', styles.heroBanner)}>
      <div className="container">
        <h1 className="hero__title">Katalog</h1>
        <p className="hero__subtitle">{siteConfig.tagline}</p>
        <div className={styles.buttons}>
          <Link
            className="button button--secondary button--lg"
            to="/docs/intro">
            Getting Started
          </Link>
        </div>
      </div>
    </header>
  );
}

function HomepageContent() {
  return (
    <section>
      <div className="container">
        <div className="row">
          <div className={clsx('col col--7', styles.features)}>
            <h2>Features</h2>
            <ul>
              <li>Made with <code>Jetpack Compose</code> and can preview <code>Composable</code>.</li>
              <li>Can easily register UI components using a <code>DSL</code>, and group them.</li>
              <li>Supports <code>Android View</code>, <code>DataBinding</code>, <code>ViewBinding</code> and <code>Fragment</code>.</li>
            </ul>
          </div>
          <ul className={clsx('col col--5', styles.images)}>
            <li><img src="../../img/screenshot_light.png"/></li>
            <li><img src="../../img/screenshot_dark.png"/></li>
          </ul>
        </div>
      </div>
    </section>
  )
}

export default function Home() {
  return (
    <Layout
      description="Made with Jetpack Compose and can preview Composable. Can easily register UI components using a DSL, and group them. Supports Android View, DataBinding, ViewBinding and Fragment.">
      <HomepageHeader />
      <main>
        <HomepageContent />
      </main>
    </Layout>
  );
}
